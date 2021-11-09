public class BufferTester {
    public static void main(String[] args) {
        //class we built. function we built 
        BufferWriter.writeString("Hello World");
        BufferWriter.saveAndClose();
        System.out.println(BufferWriter.readString());
    }
}
