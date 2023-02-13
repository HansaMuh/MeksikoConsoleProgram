package MeksikoConsole;

import java.util.*;

public class Main
{

    public static List<Karyawan> Database;

    public static InputMenu MainInput;
    public static ViewMenu MainView;
    public static UpdateMenu MainUpdate;
    public static DeleteMenu MainDelete;

    public static boolean InProcess;

    public static void main(String[] args)
    {
        Initialize();
        Process();
    }

    public static void Initialize()
    {
        Database = new ArrayList<Karyawan>();
        MainInput = new InputMenu();
        MainView = new ViewMenu();
        MainUpdate = new UpdateMenu();
        MainDelete = new DeleteMenu();
    }

    public static void Process()
    {
        String code;
        InProcess = true;
        while (InProcess)
        {
            System.out.printf("\nExit - 0\nInput Menu - 1\nView Menu - 2\nUpdate Menu - 3\nDelete Menu - 4\n");
            System.out.printf("Input nomor kode untuk menu yang ingin digunakan: ");
            code = MainInput.DataScanner.next();

            switch (code) {
                case "0":
                    InProcess = false;
                    break;
                case "1":
                    MainInput.ScanData();
                    break;
                case "2":
                    MainView.ViewDatabase();
                    break;
                case "3":
                    MainUpdate.InputUpdate();
                    break;
                case "4":
                    MainDelete.InputDelete();
                    break;
                default:
                    System.out.printf("Nomor kode yang dimasukkan tidak sesuai dengan format di atas\n");
                    break;
            }
        }
    }

}