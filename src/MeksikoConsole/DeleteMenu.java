package MeksikoConsole;

public class DeleteMenu 
{

	public DeleteMenu()
	{
	}

	public void InputDelete()
	{
		Main.MainView.ViewDatabase();
		System.out.printf("Input nomor urutan karyawan yang ingin dihapus: ");
		int targetIndex = Main.MainInput.DataScanner.nextInt();
		
		if (Main.Database.get(targetIndex - 1) != null)
		{
			String employeeCode = Main.Database.get(targetIndex - 1).Kode;
			Main.Database.remove(targetIndex - 1);
			System.out.printf("Karyawan dengan kode %s berhasil dihapus\n", employeeCode);
		}
		else
		{
			System.out.printf("Gagal menemukan karyawan dengan nomor urutan tersebut\n");
		}
	}
	
}
