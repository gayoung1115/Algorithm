function solution(n) {
    let pizza = 7;
    if(n<=pizza) return 1;
    else{
    while((pizza<n)){
        pizza +=7;
    }
        return pizza/7;
    }
}