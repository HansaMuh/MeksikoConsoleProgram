package MeksikoConsole;

public class UpdateMenu 
{

	public UpdateMenu()
	{
	}
	
	public void InputUpdate()
	{
		Main.MainView.ViewDatabase();
		System.out.printf("Input nomor urutan karyawan yang ingin diperbarui: ");
		int targetIndex = Main.MainInput.DataScanner.nextInt();
		
		if (Main.Database.get(targetIndex - 1) != null)
		{
			System.out.printf("Input data sesuai dengan yang diminta. Jika ingin menggunakan data original, isikanlah dengan \"0\" (tanpa tanda kutip)\n");
			UpdateData(targetIndex - 1);
		}
		else
		{
			System.out.printf("Gagal menemukan karyawan dengan nomor urutan tersebut\n");
		}
	}
	
	public void UpdateData(int targetIndex)
	{
		String targetName = "[ERROR]", targetGender = "[ERROR]", targetRole = "[ERROR]";
		
		// Input Name
		while (targetName == "[ERROR]")
		{
			targetName = Main.MainInput.InputName();
		}

		// Input Gender
		while (targetGender == "[ERROR]")
		{
			targetGender = Main.MainInput.InputGender();
		}
		
		// Input Role
		while (targetRole == "[ERROR]")
		{
			targetRole = Main.MainInput.InputRole();
		}
		
		Karyawan targetKaryawan = Main.Database.get(targetIndex);
		if (targetName.compareTo("0") > 0)
		{
			targetKaryawan.Nama = targetName;
		}
		if (targetGender.compareTo("0") > 0)
		{
			targetKaryawan.Kelamin = targetGender;
		}
		if (targetRole.compareTo("0") > 0)
		{
			targetKaryawan.Jabatan = targetRole;
		}
		
		System.out.printf("Berhasil membarui karyawan dengan kode %s\n", targetKaryawan.Kode);
	}
	
}
