package aiot.mclaren.senna.host.controller;


import aiot.mclaren.commons.response.DataResponse;
import aiot.mclaren.senna.host.service.IDeviceService;
import aiot.mclaren.senna.sdk.api.DeviceApi;
import aiot.mclaren.senna.sdk.dto.DeviceDTO;
import aiot.mclaren.senna.sdk.request.DeviceBody;
import aiot.mclaren.senna.sdk.request.DeviceQuery;
import aiot.mclaren.senna.sdk.response.SimplePage;
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
public class DeviceController implements DeviceApi {

    @Autowired
    private IDeviceService deviceService;

    @Override
    public DataResponse<DeviceDTO> create(DeviceBody body) {
        return deviceService.create(body);
    }

    @Override
    public DataResponse<SimplePage<DeviceDTO>> selectPage(DeviceQuery query) {
        return deviceService.selectPage(query);
    }
}

