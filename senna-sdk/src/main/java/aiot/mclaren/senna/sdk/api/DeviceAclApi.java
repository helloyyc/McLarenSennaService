package aiot.mclaren.senna.sdk.api;

import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.sdk.dto.DeviceAclDTO;
import aiot.mclaren.senna.sdk.request.DeviceAclBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author lsj
 * @date 2021/3/5 11:02
 */
@Api(tags = "设备主题ACL")
@FeignClient(name = "${spring.application.name}", contextId = "device_acl")
@RequestMapping("device_acls")
public interface DeviceAclApi {

    @ApiOperation("创建ACL")
    @PostMapping
    DataResponse<DeviceAclDTO> create(@Validated @RequestBody DeviceAclBody body);

    @ApiOperation("更新ACL")
    @PutMapping
    DataResponse<DeviceAclDTO> update(@Validated @RequestBody DeviceAclBody body);

    @ApiOperation("删除ACL")
    @DeleteMapping("{id}")
    DataResponse<Boolean> deleteById(@PathVariable Long id);
}
