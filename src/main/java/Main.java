
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná DAINF - Departamento
 * Acadêmico de Informática IF62C - Fundamentos de Programação 2
 *
 * Tomás Abril
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        Runtime rt = Runtime.getRuntime();
        String os = System.getProperty("os.name");
        System.out.println("Executando em " + os);
        System.out.println("Número de processadores: " + rt.availableProcessors());
        System.out.println("Memória total (MB):  " + rt.totalMemory() / (1024 * 1024));
        System.out.println("Memória livre (MB):  " + rt.freeMemory() / (1024 * 1024));
        System.out.println("Memória máx VM (MB): " + rt.maxMemory() / (1024 * 1024));

        Process programa;
        String cmd;

        Scanner input = new Scanner(System.in);
        System.out.println("Nome do arquivo: ");
        String arquivo = input.next();

        cmd = "gedit " + arquivo;

        programa = rt.exec(cmd);
        programa.waitFor();

        File file = new File(arquivo);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        if (file.exists()) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        }else{
            System.out.println("arquivo nao existe");
        }
        reader.close();
        input.close();

    }
}
