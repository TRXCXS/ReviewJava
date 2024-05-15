alert("Hello World! out");

// JS对象
// 1，数组
// 特点：长度可变、类型可变
// 常用属性：length
// 常用方法：forEach（遍历有值元素），push（添加元素到数组末尾），splice（删除元素）
let arr1 = new Array(1, 2, 3, 4, 5);
let arr2 = [1, 2, 3, 4, 5];

arr1[9] = true;
arr1[10] = 'Hello World!';
/*
for (let i = 0; i < arr1.length; i++) {
    console.log(arr1[i]);
}

arr2.forEach(function (item) {
    console.log(item);
});
arr2.forEach((item) => {
    console.log(item);
});
*/

arr2.push(7, 8, 9);
// console.log(arr2);
arr2.splice(1, 3); // 第一个参数是删除的起始位置，第二个参数是删除的个数
// console.log(arr2);

// 2，字符串
// 常用属性：length
// 常用方法：charAt（获取指定位置的字符），indexOf（获取指定字符串的位置），trim（去除首尾空格），substring（获取指定位置的字符串，左闭右开）
let str1 = new String('Hello World!');
let str2 = 'Hello World!';
