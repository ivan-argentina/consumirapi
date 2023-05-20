package ventanas;

import java.net.HttpURLConnection;
import java.net.URL;
import jdk.nashorn.internal.parser.JSONParser;
import java.util.Scanner;
import jdk.nashorn.internal.objects.Global;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

/**
 *
 * @author Ivan Genari
 */
public class frmInicio extends javax.swing.JFrame {

    public frmInicio() {
        initComponents();
        setSize(500, 400);
        setResizable(false);
        setTitle("Consumir Api");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
           
            //URL url = new URL("http://api.weatherstack.com/current?access_key=9abf0c4516ffed5fc9f76d8a01931a45&query=Santa%20Fe");
            //URL url = new URL("https://api.bluelytics.com.ar/v2/latest");
            URL url = new URL("https://www.dolarsi.com/api/api.php?type=valoresprincipales");
            
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            
            int responseCode = conn.getResponseCode();
            if(responseCode != 200){
                throw new RuntimeException("Ocurrio un error" + responseCode);
            }else{
                StringBuilder informationString = new StringBuilder();
               Scanner scanner = new Scanner(url.openStream());
                                while(scanner.hasNext()){
                   informationString.append(scanner.nextLine());
                }
                scanner.close();
                System.out.println(informationString);
               JSONArray jsonArray = new JSONArray(informationString.toString());
               JSONObject jsonObject = jsonArray.getJSONObject(0);
                //System.out.println(jsonObject.getString("type"));
                
                System.out.println(jsonObject.getString("oficial"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
