package aiot.mclaren.senna.host.controller;


import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.host.service.IDeviceAclService;
import aiot.mclaren.senna.sdk.api.DeviceAclApi;
import aiot.mclaren.senna.sdk.dto.DeviceAclDTO;
import aiot.mclaren.senna.sdk.request.DeviceAclBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lsj
 * @since 2021-02-06
 */
@RestController
public class DeviceAclController implements DeviceAclApi {

    @Autowired
    private IDeviceAclService deviceAclService;

    @Override
    public DataResponse<DeviceAclDTO> create(DeviceAclBody body) {
        return deviceAclService.createOrUpdate(body);
    }

    @Override
    public DataResponse<DeviceAclDTO> update(DeviceAclBody body) {
        return deviceAclService.createOrUpdate(body);
    }

    @Override
    public DataResponse<Boolean> deleteById(Long id) {
        return DataResponse.success(deviceAclService.removeById(id));
    }
}

