const windowPx = {
	height: window.innerHeight,
	width: window.innerWidth
}
setPx = () => {
	document.querySelector('.container').style.height = windowPx.height + 'px';
	document.querySelector('.container').style.width = windowPx.width + 'px';
	document.querySelector('#main').style.height = windowPx.height + 'px';
	document.querySelector('#main').style.width = windowPx.width + 'px';
}
//hideElement =()=>{
//	
//}
document.querySelector('#GoRegister').addEventListener('click', (e) => {
	//	let ev  = e|| window.event
	//	let target = ev.target || ev.srcElement;
	//	alert(target.classList)
	document.querySelector('.login').classList.remove('showElement');
	document.querySelector('.register').classList.add('showElement')
});
document.querySelector('#loginSubmit').addEventListener('click', () => {
	let userInfo = {
		account: document.getElementById('loginAccount').value,
		password: document.getElementById('loginPassword').value
	}
	document.querySelector('#user').classList.add('hideElement');
	document.querySelector('#main').classList.remove('hideElement');

});
document.querySelector('#back').addEventListener('click', (e) => {
	//	let ev  = e|| window.event
	//	let target = ev.target || ev.srcElement;
	//	alert(target.classList)
	document.querySelector('.login').classList.add('showElement');
	document.querySelector('.register').classList.remove('showElement');
});
document.querySelector('.rightNav').addEventListener('click', (e) => {
	let ev = e || ev.target;
	let target = ev.target || ev.srcElement;
	if(target.nodeName.toLowerCase() == 'a') {
//		target.parentNode.previousSibling.classList.remove('active');
//		target.parentNode.nextSibling.classList.remove('active');
		for (let i = 0;i<3;i++) {
			document.querySelector('.rightNav').getElementsByTagName('li')[i].classList.remove('active');
			document.querySelectorAll('.menuItems')[i].style.display = 'none'
			let item = document.querySelectorAll('.menuItems')[i];
			if(item.getAttribute('data-id') == target.parentNode.id){
				item.style.display = 'block'
			}
		}
		target.parentNode.classList.add('active');
	}
})
window.onload = () => {
	setPx(); //
}
window.onresize = setPx();