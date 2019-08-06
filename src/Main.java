import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        ClienteRest.consumir();
    }
}



class ClienteRest {

    public static String RUTA = "https://api.nubefact.com/api/v1/d0e1557f-7065-4bd6-92bb-6bae4d476768";
    public static String TOKEN = "a6f0ef9123a14c2094d0a19ce6ce71c658c2c42ed0624541bf21405406a71f4c";


    public static void consumir(){
        try {

            URL url = new URL(RUTA);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setDoOutput(true);
            conexion.setRequestProperty("Content-Type","application/json");
            conexion.setRequestProperty("Authorization",TOKEN);

            String jsonString = consultarComprobante();
            //String jsonString = enviarComprobante();

            //System.out.println(jsonString);
            OutputStream os = conexion.getOutputStream();
            os.write(jsonString.getBytes());
            os.flush();

           /* if (conexion.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conexion.getResponseCode());
            } */

            InputStream respuesta;
            if (conexion.getResponseCode() != 200) {
                //throw new RuntimeException("Failed : HTTP error code : " + conexion.getResponseCode());
                respuesta = conexion.getErrorStream();
                System.out.println(respuesta);
            }else{
                respuesta = conexion.getInputStream();
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((respuesta)));

            String output;
            System.out.println("Output from Server ....");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conexion.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String consultarComprobante(){

        String jsonString = "{\n " +
                "\"operacion\":\"consultar_comprobante\",\n " +
                "\"tipo_de_comprobante\":\"2\",\n " +
                "\"serie\":\"B002\",\n " +
                "\"numero\":\"1\" " +
                "\n}";
        return jsonString;
    }


    public static String enviarComprobante(){

        String jsonString = "{\n   " +
                "\"operacion\": \"generar_comprobante\",\n   " +
                "\"tipo_de_comprobante\": \"2\",\n   " +
                "\"serie\": \"B001\",\n   " +
                "\"numero\": \"5\",\n   " +
                "\"sunat_transaction\": 1,\n   " +
                "\"cliente_tipo_de_documento\": 1,\n   " +
                "\"cliente_numero_de_documento\": \"41920371\",\n   " +
                "\"cliente_denominacion\": \"JORGE LOPEZ\",\n   " +
                "\"cliente_direccion\": \"JIRON COLOR 211\",\n   " +
                "\"cliente_email\": \"demo@gmail.com\",\n   " +
                "\"cliente_email_1\": \"\",\n   " +
                "\"cliente_email_2\": \"\",\n   " +
                "\"fecha_de_emision\": \"18-02-2019\",\n   " +
                "\"fecha_de_vencimiento\": \"\",\n   " +
                "\"moneda\": \"1\",\n   " +
                "\"tipo_de_cambio\": \"\",\n   " +
                "\"porcentaje_de_igv\": \"18.00\",\n   " +
                "\"descuento_global\": \"\",\n   " +
                "\"total_descuento\": \"\",\n   " +
                "\"total_anticipo\": \"\",\n   " +
                "\"total_gravada\": \"600\",\n   " +
                "\"total_inafecta\": \"\",\n   " +
                "\"total_exonerada\": \"\",\n   " +
                "\"total_igv\": \"108\",\n   " +
                "\"total_gratuita\": \"\",\n   " +
                "\"total_otros_cargos\": \"\",\n   " +
                "\"total\": \"708\",\n   " +
                "\"percepcion_tipo\": \"\",\n   " +
                "\"percepcion_base_imponible\": \"\",\n   " +
                "\"total_percepcion\": \"\",\n   " +
                "\"total_incluido_percepcion\": \"\",\n   " +
                "\"detraccion\": \"false\",\n   " +
                "\"observaciones\": \"\",\n   " +
                "\"documento_que_se_modifica_tipo\": \"\",\n   " +
                "\"documento_que_se_modifica_serie\": \"\",\n   " +
                "\"documento_que_se_modifica_numero\": \"\",\n   " +
                "\"tipo_de_nota_de_credito\": \"\",\n   " +
                "\"tipo_de_nota_de_debito\": \"\",\n   " +
                "\"enviar_automaticamente_a_la_sunat\": \"true\",\n   " +
                "\"enviar_automaticamente_al_cliente\": \"false\",\n   " +
                "\"codigo_unico\": \"\",\n   " +
                "\"condiciones_de_pago\": \"\",\n   " +
                "\"medio_de_pago\": \"\",\n   " +
                "\"placa_vehiculo\": \"\",\n   " +
                "\"orden_compra_servicio\": \"\",\n   " +
                "\"tabla_personalizada_codigo\": \"\",\n   " +
                "\"formato_de_pdf\": \"\",\n   " +
                "\"items\": [\n         " +
                "{\n            " +
                "\"unidad_de_medida\": \"NIU\",\n            " +
                "\"codigo\": \"001\",\n            " +
                "\"descripcion\": \"DETALLE DEL PRODUCTO\",\n            " +
                "\"cantidad\": \"1\",\n            " +
                "\"valor_unitario\": \"500\",\n            " +
                "\"precio_unitario\": \"590\",\n            " +
                "\"descuento\": \"\",\n            " +
                "\"subtotal\": \"500\",\n            " +
                "\"tipo_de_igv\": \"1\",\n            " +
                "\"igv\": \"90\",\n            " +
                "\"total\": \"590\",\n            " +
                "\"anticipo_regularizacion\": \"false\",\n            " +
                "\"anticipo_documento_serie\": \"\",\n            " +
                "\"anticipo_documento_numero\": \"\"\n         " +
                "}, {\n            " +
                "\"unidad_de_medida\": \"ZZ\",\n            " +
                "\"codigo\": \"001\",\n            " +
                "\"descripcion\": \"DETALLE DEL SERVICIO\",\n            " +
                "\"cantidad\": \"5\",\n            " +
                "\"valor_unitario\": \"20\",\n            " +
                "\"precio_unitario\": \"23.60\",\n            " +
                "\"descuento\": \"\",\n            " +
                "\"subtotal\": \"100\",\n            " +
                "\"tipo_de_igv\": \"1\",\n            " +
                "\"igv\": \"18\",\n            " +
                "\"total\": \"118\",\n            " +
                "\"anticipo_regularizacion\": \"false\",\n            " +
                "\"anticipo_documento_serie\": \"\",\n            " +
                "\"anticipo_documento_numero\": \"\"\n         " +
                "}\n   ]\n" +
                "}";
        return jsonString;
    }


}