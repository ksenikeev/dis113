import ru.itis.semestr2.model.Car;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        try (
        FileOutputStream fos = new FileOutputStream("test.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            Car car = new Car();
            car.setColor("red");
            oos.writeObject(car);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
