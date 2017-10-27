import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.zip.CRC32;
import java.util.Arrays;
import java.nio.ByteBuffer;


public class Ipv4Client {
     
     public static void main(String[] args) throws Exception {
        try {
            Socket socket = new Socket("18.221.102.182", 38103);
            System.out.println("Connected to server.");
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            
            ByteBuffer ipv4 = new ByteBuffer();
            
            for(int i = 1; i <= 12; i++) {
                ipv4.put((byte)0x45);        // version + HLen
                ipv4.put((byte)0x00);        // TOS
                ipv4.put((byte)(20 + 2**i)); // total length
                ipv4.put((byte)0x00);        // ident
                ipv4.put((byte)0x00);        // ident
                ipv4.put((byte)0x40);        // Flags
                ipv4.put((byte)0x00);        // Offset
                ipv4.put((byte)50);          // TTL
                ipv4.put((byte)0x06);        // Protocol
                
                Bytebuffer noChecksumIpv4 = ipv4;     // temp bytebuffer for checksum
                noChecksumIpv4.put((byte)0x0);        //
                noChecksumIpv4.put((byte)0x0);        //
                noChecksumIpv4.put(
                ipv4.put(checksum(noChecksumIpv4);    //
                
                
            }
            
        }
    }
    
    public static short checksum(byte[] b) {
        int sum = 0;
        
        for(int i = 0; i < b.length; i++) {
            byte upper = b[i++];
            byte lower;
            
            if(i < b.length)
                lower = b[i];
            else
                lower = 0;
            
            int result = 0;
            result = (result | (upper<<0x8 & 0xFF00));
            result = (result | (lower & 0x00FF));

            sum += result;
            if((sum & 0xFFFF0000) != 0) {
                sum = sum & 0xFFFF;
                sum += 1;
            }
        }
        return (short)~(sum & 0xFFFF);
    }
        

}
