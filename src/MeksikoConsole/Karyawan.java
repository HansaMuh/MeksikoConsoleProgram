package MeksikoConsole;

public class Karyawan 
{

	public Karyawan(String kode, String nama, String kelamin, String jabatan)
	{
		this.Kode = kode;
		this.Nama = nama;
		this.Kelamin = kelamin;
		this.Jabatan = jabatan;
		
		switch (this.Jabatan)
		{
			case "Manager":
				this.Gaji = 8000000;
				break;
			case "Supervisor":
				this.Gaji = 6000000;
				break;
			case "Admin":
				this.Gaji = 4000000;
				break;
		}
	}
	

	//// Public Properties
	
	// Format: MM-XXXX
	public String Kode;
	
	// Format: abc
	public String Nama;
	
	// Format: Laki-Laki / Perempuan
	public String Kelamin;
	
	// Format: Manager / Supervisor / Admin
	public String Jabatan;
	
	// Format: 8.000.000 (Manager) / 6.000.000 (Supervisor) / 4.000.000 (Admin)
	public long Gaji; 

	
	//// Public Methods
	public int ChangeProperties()
	{
		// Change
		return 0;
	}
	
}
