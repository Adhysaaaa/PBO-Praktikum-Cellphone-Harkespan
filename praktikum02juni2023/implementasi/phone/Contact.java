package implementasi.phone;

public class Contact {
    String nama;
    String nomor;
    int pulsa;

    public Contact(String nama, String nomor)
    {
        this.nama = nama;
        this.nomor = nomor;
        this.pulsa = 0;
    }

    String getNama()
    {
        return this.nama;
    }

    String getNomor()
    {
        return this.nomor;
    }

    public int getPulsa() {
        return pulsa;
    }

    public void setPulsa(int pulsa) {
        this.pulsa = pulsa;
    }

}