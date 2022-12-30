function solution(common) {
    if((common[2] - common[1])===(common[1]-common[0])) {
       var i = common[1]-common[0];
        return common.pop()+i
       }
    else{
        var i2 = common[1]/common[0];
        return common.pop()*i2
    }
}