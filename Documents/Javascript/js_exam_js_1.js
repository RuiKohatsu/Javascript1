
'use strict'; //構文のチェック
console.log("aaa");

    document.getElementById('kokugo').value = 0;
    document.getElementById('eigo').value = 0;
    document.getElementById('sugaku').value = 0;

document.getElementById('btn').addEventListener('click', () => {
    
    const num = parseInt(document.getElementById('kokugo').value);
    const num1 = parseInt(document.getElementById('eigo').value);
    const num2 = parseInt(document.getElementById('sugaku').value);
    const sum = num+num1+num2;
    const avg = sum/3;

    document.getElementById('sum').textContent = sum;
    document.getElementById('avg').textContent = avg;

  });

  document.getElementById('btn1').addEventListener('click', () => {
    
    document.getElementById('kokugo').value = 0;
    document.getElementById('eigo').value = 0;
    document.getElementById('sugaku').value = 0;

    document.getElementById('sum').textContent = "";
    document.getElementById('avg').textContent = "";

  });

