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

// 3，JSON
// JSON字符串中的对象不能含有方法
// JSON.parse，JSON字符串 -> JS对象
// JSON.stringify，JS对象 -> JSON字符串
let StudentJSON = '{"name": "Trxcx", "age": 22, "hasWork": false, "hobbies": ["Java", "run"], "address": {"province": "Guangdong", "city": "Guangzhou"},"bike": null}'
alert(StudentJSON.name); // undefined，不能通过JSON字符串.属性的形式访问

let student = JSON.parse(StudentJSON);
alert(student.name);
let JSON_String = JSON.stringify(student);
alert(JSON_String);

// 4，BOM，Browser Object Model，浏览器对象模型，用于控制浏览器行为
    // 1，window：浏览器窗口对象(window.可省略)
        window.navigator
        window.history
        window.location
        // window.alert()
        // let select = window.confirm()
        // window.setInterval() // 按照指定的周期（ms）来调用函数或计算表达式
        // window.setTimeout() // 在指定的毫秒数后调用函数或计算表达式
    // 2，navigator：浏览器对象
    // 3，screen：屏幕对象
    // 4，history：历史记录对象
    // 5，location：地址栏对象
        alert(location.href)
        location.href = "https://www.baidu.com" // 地址栏URL设置为指定的并自动跳转

// 5，DOM，Document Object Model ，文档对象模型，用于操作XML、HTML文档
    // 1，Document：整个文档对象
    // 2，Element：元素对象
    // 3，Attribute：属性对象
    // 4，Text：文本对象
    // 5，Comment：注释对象

    // 根据id获取
    let div = document.getElementById('div1');
    // 根据标签名获取
    let divs1 = document.getElementsByTagName('div');
    // 根据name获取
    let divs2 = document.getElementsByName('hobby');
    // 根据class获取
    let divs3 = document.getElementsByClassName('divClass');

// 6、事件绑定
    // 1、通过属性绑定
    // <input type="button" value="按钮" onclick="on()">
    // <script>
    //     function on() {
    //     alert("Hello World!");
    // }
    // </script>
    //
    // 2、通过DOM绑定
    // <input type="button" value="按钮" id="btn">
    // <script>
    //     let btn = document.getElementById('btn');
    //     btn.onclick = function () {
    //         alert("Hello World!");
    //     }
    // </script>
