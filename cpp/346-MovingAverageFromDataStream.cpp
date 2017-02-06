class MovingAverage {
    int size;
    double sum;
    queue<int> window;
public:
    /** Initialize your data structure here. */
    MovingAverage(int size) {
        this->size = size;
        sum = 0;
    }

    double next(int val) {
        window.push(val);
        sum += val;
        if (window.size() > size){
            sum -= window.front();
            window.pop();
        }
        double avg = sum / window.size();
        return avg;
    }
};

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
