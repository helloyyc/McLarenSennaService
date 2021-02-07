package aiot.mclaren.senna.host;

import aiot.mclaren.senna.host.mapper.CategoryMapper;
import aiot.mclaren.senna.host.service.ICategoryService;
import aiot.mclaren.senna.model.entity.Category;
import cn.hutool.core.io.IoUtil;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author lsj
 * @date 2021/2/7 18:05
 */
@SpringBootTest
@Slf4j
class CategoryTests {

    @Autowired
    private ICategoryService categoryService;

    @Test
    void categoryInit() {
        try (InputStream in = CategoryTests.class.getClassLoader().getResourceAsStream("category.json")) {
            if (in == null) {
                return;
            }
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            String json = IoUtil.read(in, StandardCharsets.UTF_8);
            List<Category> categories = gson.fromJson(json, new TypeToken<List<Category>>(){}.getType());
            categoryService.saveOrUpdateBatch(categories);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
