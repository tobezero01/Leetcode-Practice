public class Stack {
    private int maxSize; // Kích thước tối đa của stack
    private int[] stackArray; // Mảng lưu trữ các phần tử của stack
    private int top; // Index của phần tử đỉnh của stack

    // Khởi tạo stack với kích thước maxSize
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new int[maxSize];
        this.top = -1; // Stack rỗng khi top = -1
    }

    // Thêm một phần tử vào đỉnh của stack
    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full, cannot push " + value);
            return;
        }
        stackArray[++top] = value;
    }

    // Lấy và xóa phần tử đỉnh của stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[top--];
    }

    // Lấy phần tử đỉnh của stack nhưng không xóa nó
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArray[top];
    }

    // Kiểm tra xem stack có rỗng không
    public boolean isEmpty() {
        return (top == -1);
    }

    // Kiểm tra xem stack có đầy không
    public boolean isFull() {
        return (top == maxSize - 1);
    }


}
