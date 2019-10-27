
package com.carljmosca.demo;

import com.carljmosca.demo.resource.HelloResource;
import com.carljmosca.demo.resource.UserResource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class DemoApplication extends Application {
    
    public DemoApplication() {
        
    }

    @Override
    public Set<Class<?>> getClasses() {        

        return new HashSet<>(Arrays.asList(UserResource.class, HelloResource.class));

    }

}
