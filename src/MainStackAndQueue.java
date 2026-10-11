import java.util.Scanner;

public class MainStackAndQueue {
    // Node untuk menyimpan data pada stack atau queue
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // Struktur data stack dengan prinsip LIFO (Last In First Out)
    static class Stack {
        private Node top;

        // Menambahkan elemen ke atas stack
        public void push(int value) {
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
            System.out.println("Push: " + value);
        }

        // Menghapus elemen paling atas dari stack
        public void pop() {
            if (top == null) {
                System.out.println("Stack kosong");
                return;
            }
            System.out.println("Pop: " + top.value);
            top = top.next;
        }

        // Menampilkan isi stack dari atas ke bawah
        public void display() {
            if (top == null) {
                System.out.println("Stack kosong");
                return;
            }
            Node temp = top;
            System.out.print("Stack: ");
            while (temp != null) {
                System.out.print(temp.value + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    // Struktur data queue dengan prinsip FIFO (First In First Out)
    static class Queue {
        private Node front;
        private Node rear;

        // Menambahkan elemen ke bagian belakang queue
        public void enqueue(int value) {
            Node newNode = new Node(value);
            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            System.out.println("Enqueue: " + value);
        }

        // Menghapus elemen paling depan dari queue
        public void dequeue() {
            if (front == null) {
                System.out.println("Queue kosong");
                return;
            }
            System.out.println("Dequeue: " + front.value);
            front = front.next;
            if (front == null) {
                rear = null;
            }
        }

        // Menampilkan isi queue dari depan ke belakang
        public void display() {
            if (front == null) {
                System.out.println("Queue kosong");
                return;
            }
            Node temp = front;
            System.out.print("Queue: ");
            while (temp != null) {
                System.out.print(temp.value + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    // Menu utama program untuk menjalankan operasi stack dan queue
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();
        Queue queue = new Queue();

        int pilihan = 0;
        do {
            System.out.println("\n===== PROGRAM STACK & QUEUE =====");
            System.out.println("1. Push Stack");
            System.out.println("2. Pop Stack");
            System.out.println("3. Enqueue Queue");
            System.out.println("4. Dequeue Queue");
            System.out.println("5. Tampilkan Stack");
            System.out.println("6. Tampilkan Queue");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }

            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan angka: ");
                    stack.push(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.print("Masukkan angka: ");
                    queue.enqueue(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 4:
                    queue.dequeue();
                    break;
                case 5:
                    stack.display();
                    break;
                case 6:
                    queue.display();
                    break;
                case 7:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 7);

        scanner.close();
    }
}