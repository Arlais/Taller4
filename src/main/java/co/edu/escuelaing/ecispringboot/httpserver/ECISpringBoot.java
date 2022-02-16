package co.edu.escuelaing.ecispringboot.httpserver;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Logger;

public class ECISpringBoot {

    private static ECISpringBoot _eciSpringBoot= new ECISpringBoot();
    private HashMap<String,Method> services;

    private  ECISpringBoot(){};

    public ECISpringBoot getInstance(){
        return _eciSpringBoot;
    }

    public void startServer(){
        try{
            HttpServer httpServer = new HttpServer();
            httpServer.start();
        } catch ()
    }

    public void loadComponents(){
        String[] componentList = searchComponentList();
    }

    public String[] searchComponentList(){
        return new String[]{co.edu.escuelaing.ecispringboot.httpserver}
    }

    private void loadServices(String componentName){
        try{
            Class c=Class.forName(componentName);
            Method[] declaredMethods  = c.getDeclaredMethods();
            for(Method m: declaredMethods){
                if(m.isAnnotationPresent(Service.class)){
                    Service a = m.getDeclaredAnnotation(Service.class);
                    services.put(a.value(),m);
                }
            }
        } catch (ClassNotFoundException e){
            Logger.getLogger(ECISpringBoot.class.getName());
        }

    }

    public String invokeService(String serviceName){
        Method serviceMethod = services.get(serviceName);
        return (String) serviceMethod.invoke(null);
    }
}
