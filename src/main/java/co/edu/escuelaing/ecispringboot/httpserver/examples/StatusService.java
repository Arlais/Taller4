package co.edu.escuelaing.ecispringboot.httpserver.examples;

import co.edu.escuelaing.ecispringboot.httpserver.Service;

public class StatusService {
    @Service("/status")
    public static String status(){
        return "Service status : OK";
    }
}
