package myclasses.fileManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoomFileManager {

    private static final String FILE_NAME = "rooms.txt";

    // Leer las habitaciones desde el archivo y devolverlas como una lista de habitaciones
    public List<Room> loadRooms() {
        List<Room> rooms = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Se asume que el archivo tiene el formato "roomNumber,roomType,price"
                String[] roomData = line.split(",");
                if (roomData.length == 3) {
                    String roomNumber = roomData[0];
                    String roomType = roomData[1];
                    double price = Double.parseDouble(roomData[2]);
                    rooms.add(new Room(roomNumber, roomType, price));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de habitaciones: " + e.getMessage());
        }
        return rooms;
    }

    public void saveRooms(List<Room> rooms) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Room room : rooms) {
                writer.write(room.getRoomNumber() + "," + room.getRoomType() + "," + room.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar las habitaciones: " + e.getMessage());
        }
    }
}