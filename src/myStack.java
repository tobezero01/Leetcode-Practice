public class myStack {
    private int[] arr;       // mảng để lưu trữ các phần tử của ngăn xếp
    private int capacity;    // dung lượng của ngăn xếp
    private int top;         // chỉ số của phần tử ở đỉnh ngăn xếp

    // Hàm khởi tạo
    public myStack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // Thêm phần tử vào ngăn xếp
    public void push(int x) {
        if (isFull()) {
            System.exit(1);
        }

        arr[++top] = x;
    }

    // Loại bỏ phần tử khỏi ngăn xếp
    public int pop() {
        if (isEmpty()) {
            System.exit(1);
        }

        return arr[top--];
    }

    // Trả về phần tử đầu tiên của ngăn xếp mà không loại bỏ nó
    public int peek() {
        if (isEmpty()) {
            System.exit(1);
        }
        return arr[top];
    }

    // Trả về số lượng phần tử hiện có trong ngăn xếp
    public int size() {
        return top + 1;
    }

    // Kiểm tra xem ngăn xếp có rỗng không
    public boolean isEmpty() {
        return top == -1;
    }

    // Kiểm tra xem ngăn xếp có đầy không
    public boolean isFull() {
        return top == capacity - 1;
    }

}
