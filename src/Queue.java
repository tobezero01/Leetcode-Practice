public class Queue {
    private int maxSize; // Kích thước tối đa của queue
    private int[] queueArray; // Mảng lưu trữ các phần tử của queue
    private int front; // Index của phần tử đầu queue
    private int rear; // Index của phần tử cuối queue
    private int nItems; // Số lượng phần tử hiện có trong queue

    // Khởi tạo queue với kích thước maxSize
    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new int[maxSize];
        this.front = 0; // Ban đầu front và rear đều là 0
        this.rear = -1;
        this.nItems = 0; // Ban đầu queue rỗng
    }

    // Thêm một phần tử vào cuối queue
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full, cannot enqueue " + value);
            return;
        }
        if (rear == maxSize - 1) {
            rear = -1; // Vòng lại nếu rear đang ở cuối mảng
        }
        queueArray[++rear] = value; // Di chuyển rear lên và thêm phần tử vào rear mới
        nItems++; // Tăng số lượng phần tử trong queue
    }

    // Lấy và xóa phần tử đầu queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int temp = queueArray[front++]; // Lấy phần tử tại vị trí front và di chuyển front lên
        if (front == maxSize) {
            front = 0; // Vòng lại nếu front đang ở cuối mảng
        }
        nItems--; // Giảm số lượng phần tử trong queue
        return temp;
    }

    // Lấy phần tử đầu queue nhưng không xóa nó
    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queueArray[front];
    }

    // Kiểm tra xem queue có rỗng không
    public boolean isEmpty() {
        return (nItems == 0);
    }

    // Kiểm tra xem queue có đầy không
    public boolean isFull() {
        return (nItems == maxSize);
    }


}
