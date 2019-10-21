package com.wl.www.dubboTools;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

public class DubboTools {


    public static void exportService(Class interfaceClass,Object interfaceImpl){
        ServiceConfig serviceConfig=new ServiceConfig();;
        serviceConfig.setApplication(new ApplicationConfig("UserCenter"));
        serviceConfig.setRegistry(new RegistryConfig("N/A"));
        serviceConfig.setInterface(interfaceClass);
        serviceConfig.setRef(interfaceImpl);
        serviceConfig.export();
    }

}
