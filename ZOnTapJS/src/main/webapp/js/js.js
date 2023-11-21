var array = [1,2,[3,4],5,[6,7]];

var re = array.reduce(function(giaTriHienTai, mangGiatri){
	return giaTriHienTai.concat(mangGiatri)
}, []);

console.log(re.join(', '));

var khoaHoc = [
	{
		toppic: "Hello 1",
		khoaHoc: [
			{
				id: 1,
				ten: "Dung"
			},
			{
				id: 2,
				ten: "Hanh"
			}
		]
	},
	{
		toppic: "Hello 2",
		khoaHoc: [
			{
				id: 3,
				ten: "Hung"
			},
			{
				id: 4,
				ten: "Loi"
			}
		]
	}
];


var t = khoaHoc.reduce(function(bienLuuTru, mangChinh,x,y){
		console.log(y);
	return bienLuuTru.concat(mangChinh.khoaHoc)
}, []);

console.log(t)

Array.prototype.reduce2 = function(callBack, khoiTao){
	var bienn = khoiTao;
	var arr = [];

	for(var i = 0; i < this.length; i++){
		if(i === 0){
			arr.push(callBack(khoiTao, this[i]));
		} else {
			arr.push(callBack(arr, this[i]));
		}
	}
	
	return arr;
};

var tt = khoaHoc.reduce2(function(luuTru, mangChinh){
	return luuTru.concat(mangChinh.khoaHoc);
}, []);

console.log(tt);




var m = khoaHoc.map(function(tuongTac, index){
	return tuongTac.khoaHoc.map(function(tuongTac2){
		return tuongTac2.ten
	});
});

console.log(m);

var stringg = t.map(function(tuongTac){
	return `<h1>${tuongTac.ten}</h1>`
});

console.log(stringg.join(''));



Array.prototype.map2 = function(callBack){
	var arr = [];
	for (var i = 0; i < this.length; i++){
		arr.push(callBack(this[i]));
	}
	
	return arr;
};


var testMap2 = t.map2(function(tuongTac){
	return `<h1>${tuongTac.ten}</h1>`
});

console.log(testMap2.join(''));


console.log("De quy");

var k = 0;
function demNguoc(arr, i, j) {
	if(k < j){
		if(i < arr.length){
			console.log(arr[i]);
			i++;
			demNguoc(arr, i, j);
		} else {
			k++;
			i = k;
			demNguoc(arr, i, j);
		}
	} else {
		return 0;
	}
};

demNguoc([1,1,2], 0, [1,1,2].length);


var headingElement = document.querySelector("h1");

headingElement.style = "color: red; font-size: 50px;";
headingElement.style = headingElement.getAttribute("style") + "; font-family: Arial;";

console.log(headingElement.style);



var boxElement = document.querySelector(".box");
boxElement.innerHTML = "<h1>Hello</h1>"












