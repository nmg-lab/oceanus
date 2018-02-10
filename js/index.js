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
document.querySelector('#GoRegister').addEventListener('click',(e)=>{
//	let ev  = e|| window.event
//	let target = ev.target || ev.srcElement;
//	alert(target.classList)
	document.querySelector('.login').classList.remove('showElement');
	document.querySelector('.register').classList.add('showElement')
});
document.querySelector('#loginSubmit').addEventListener('click',()=>{
	let userInfo = {
		account:document.getElementById('loginAccount').value,
		password:document.getElementById('loginPassword').value
	}
	document.querySelector('#user').classList.add('hideElement');
	document.querySelector('#main').classList.remove('hideElement');
	
})
document.querySelector('#back').addEventListener('click',(e)=>{
//	let ev  = e|| window.event
//	let target = ev.target || ev.srcElement;
//	alert(target.classList)
	document.querySelector('.login').classList.add('showElement');
	document.querySelector('.register').classList.remove('showElement');
})
window.onload = ()=>{
	setPx();//
}
window.onresize = setPx();
