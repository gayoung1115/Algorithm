function solution(my_str, n) {
    var answer = [];
    const a = my_str.length%n;
    const b = my_str.length/n;
    if(a===0){
        for(let i=0;i<my_str.length;i+=n)
    answer.push(my_str.substr(i,n));
    }
    else{
        for(let i=0;i<my_str.length;i+=n){
    answer.push(my_str.substr(i,n));
        }
    }
    return answer;
}