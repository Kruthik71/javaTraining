package Kruthik;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Point p=new Point(2,3);
		System.out.println(p);
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("objects1")));
		oos.writeObject(p);
		oos.flush();
		oos.close();
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File("objects1")));
		Point p1=(Point) ois.readObject();
		System.out.println(p1);
		System.out.println(p == p1);
		ois.close();
		Point3D p2=new Point3D(3,2,1);
		System.out.println(p2);
		ObjectOutputStream oos1=new ObjectOutputStream(new FileOutputStream(new File("objects2")));
		oos1.writeObject(p2);
		oos1.flush();
		oos1.close();
		ObjectInputStream ois1=new ObjectInputStream(new FileInputStream(new File("objects2")));
		Point p4=(Point) ois1.readObject();
		System.out.println(p4);
		System.out.println(p2 == p4);
		ois.close();
	}
}
