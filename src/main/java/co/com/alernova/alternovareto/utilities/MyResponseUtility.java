package co.com.alernova.alternovareto.utilities;


import org.springframework.stereotype.Component;


// el decorador @component es la clase padre de todas las anotaciones; la cual inyectamos en el controlador, servicios y repositoty
@Component
public class MyResponseUtility {

        public Boolean error;
        public String message;
        public Object data;
        /**
         * La clase MyResponseUtility es una clase que
         * permite generar un objeto de tipo MyResponse
         */
        public MyResponseUtility() {
            this.error = false;
            this.message = "success";
            this.data = null;
        }

        // este metodo restablece el listado de la peticion
        public void restart() {
            error = false;
            message = "Success";
            data = null;
        }
    }

