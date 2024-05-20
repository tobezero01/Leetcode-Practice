public class myQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor để khởi tạo hàng đợi với kích thước xác định
    public myQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Phương thức để thêm phần tử vào hàng đợi
    public void enqueue(int value) {
        if (isFull()) {
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = value;
        size++;
    }

    // Phương thức để lấy phần tử ra khỏi hàng đợi
    public int dequeue() {
        if (isEmpty()) {
            return -1;
        }
        int value = arr[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    // Kiểm tra xem hàng đợi có trống hay không
    public boolean isEmpty() {
        return size == 0;
    }

    // Kiểm tra xem hàng đợi có đầy hay không
    public boolean isFull() {
        return size == capacity;
    }

    // Lấy kích thước hiện tại của hàng đợi
    public int Size() {
        return size;
    }
}
