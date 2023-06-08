package implementasi.phone;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class Cellphone implements Phone {
    String merk;
    String type;
    int batteryLevel;
    int status;
    int volume;
    List<Contact> contacts;
    int pulsa;


    public Cellphone(String merk, String type) {
        this.merk = merk;
        this.type = type;
        this.batteryLevel = (int)(Math.random()*(100-0+1)+0);
        this.contacts = new ArrayList<>(); 
        this.pulsa = 0; 
    }

    public void powerOn() {
        this.status = 1;
        System.out.println("Ponsel menyala");
    }
    
    public void powerOff() {
        this.status = 0;
        System.out.println("Ponsel mati");
    }

    public void volumeUp() {
        if (this.status == 0) {
            System.out.println("Ponsel mati. Tidak dapat menaikkan volume");
        } else {
            this.volume++;
            if (this.volume >= 100) {
                this.volume = 100;
            }
        }
    }

    public void volumeDown() {
        if (this.status == 0) {
            System.out.println("Ponsel mati. Tidak dapat menurunkan volume");
        } else {
            this.volume--;
        }
    }

    public int getVolume() {
        return this.volume;
    }


    public void topUpPulsa(int amount) {
        if (amount > 0) {
            pulsa += amount;
            System.out.println("Top up pulsa sebesar " + amount +" berhasil.");
        } else {
            System.out.println("Jumlah pulsa yang dimasukkan tidak valid.");
        }
    }

public void checkPulsa() {
    System.out.println("Sisa pulsa: " + pulsa);
}

public void tambahContact(String nama, String nomor) {
    Contact contact = new Contact(nama, nomor);
    contacts.add(contact);
    System.out.println("Kontak berhasil ditambahkan: " + contact.getNama() + " - " + contact.getNomor());

    if (pulsa > 0) {
        contact.setPulsa(contact.getPulsa() + pulsa);
        System.out.println("Pulsa ditambahkan ke kontak " + contact.getNama());
        pulsa = 0;
    }
}

public List<Contact> getContacts() {
    return contacts;
}

public void tampilContacts() {
    if (this.contacts.isEmpty()) {
        System.out.println("Daftar kontak kosong.");
    } else {
        System.out.println("Daftar Kontak:");
        for (Contact contact : this.contacts) {
            System.out.println("Nama: " + contact.getNama());
            System.out.println("Nomor: " + contact.getNomor());
            System.out.println("--------------------");
        }
    }
}

public List<Contact> searchContactByName(String name) {
    List<Contact> foundContacts = new ArrayList<>();

    for (Contact contact : this.contacts) {
        if (contact.getNama().equalsIgnoreCase(name)) {
            foundContacts.add(contact);
        }
    }

    return foundContacts;
}


}