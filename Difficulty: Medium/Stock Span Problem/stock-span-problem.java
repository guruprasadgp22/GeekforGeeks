class Pair {
    int price;
    int span;
    
    Pair(int price, int span) {
        this.price = price;
        this.span = span;
    }
}

class SpanTree {
    Stack<Pair> stack;
    SpanTree() {
        stack = new Stack<>();
    }
    
    int next(int price) {
        int days = 1;
        
        while(!stack.isEmpty() && stack.peek().price <= price) {
            days += stack.peek().span;
            stack.pop();
        }
        
        stack.add(new Pair(price, days));
        return days;
    }
}

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        SpanTree st = new SpanTree();
        ArrayList<Integer> res = new ArrayList<>();
        for(int ele: arr) {
            res.add(st.next(ele));
        }
        
        return res;
    }
}