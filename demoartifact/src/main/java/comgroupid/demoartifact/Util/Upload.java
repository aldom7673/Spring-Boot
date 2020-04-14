package comgroupid.demoartifact.Util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Upload {
    public static String subirArchivo(MultipartFile multiPart, String ruta){
        String nombreArchivo = multiPart.getOriginalFilename();
        try {
            File imageFile = new File(ruta + nombreArchivo);
            System.out.println("Archivo: " + imageFile.getAbsolutePath() );
            multiPart.transferTo(imageFile);
            return nombreArchivo;
        } catch (IOException e) {
            System.out.println("Error al subir el archivo : " + e.getMessage() );
            return null;
        }
    }
}