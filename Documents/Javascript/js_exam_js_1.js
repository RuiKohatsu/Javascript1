
'use strict'; //構文のチェック
console.log("aaa");

document.getElementById('btn').addEventListener('click', () => {
    
    const num = parseInt(document.getElementById('kokugo').value);
    const num1 = parseInt(document.getElementById('eigo').value);
    const num2 = parseInt(document.getElementById('sugaku').value);
    const sum = num+num1+num2;
    const avg = sum/3;

    console.log(num);
    console.log(num1);
    console.log(num2);

    document.getElementById('sum').textContent = sum;
    document.getElementById('avg').textContent = avg;

  });

