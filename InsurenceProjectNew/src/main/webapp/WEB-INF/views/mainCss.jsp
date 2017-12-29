<style>
* {
	margin: 0;
	padding: 0;
	letter-spacing: 0;
	font-family: "Palatino Linotype", "Book Antiqua", Palatino, serif;
}

#headerNav {
    height: 100px;
    background-color: #660513;
    border-radius: 20px;
     box-shadow: 1px 10px 5px #888888;
     top: 0px;
     position: fixed;
     width: 100%;
     z-index: 10;
}
#logo {
	margin: 25px;
	width: 50%;
	float: left;
}
#mainNav {
	font-size: 20pt;
	font-family: 'arial';
	color: white;
	padding-top: 25px;

}
#mainNav ul li {
	display: inline-block;
	list-style: none;
	width: 13%;
	text-align: left;
	vertical-align: text-bottom;
}
#verticalNavigationLeft {
	width: 300px;
	min-height: 550px;
	border: lightgrey .5px solid;
	border-radius: 20px;
	box-shadow: 1px 10px 5px #888888;
	position: fixed;
	z-index: 11;
	top: 100px
}
#head {
	text-align: center;
	color: white;
	background-color: #660513;
	border-bottom: lightgrey .5px solid;
	min-height: 50px;
	border-radius: 20px 20px  0 0;
}
.verticalButtons {
	height: 40px;
	border:lightgrey .5px solid;
	padding-top: 10px;
	padding-left: 40px;
	transition: .6s;
	cursor: pointer;
	color: black;

}
.verticalButtons:hover {
	background-color: lightgray;
}
.horizontalButton {
	transition: .8s;

	position: relative;
	bottom: 0px;
	margin: 0;
	padding: 0;
	height: 100px;
	vertical-align: text-bottom;

}
.horizontalButton:hover {
	opacity: .5;
	cursor: pointer;

}
#verticalNavigationRight {
	width: 300px;
	min-height: 550px;
	border: lightgrey .5px solid;
	border-radius: 20px;
	box-shadow: 1px 10px 5px #888888;
	position: fixed;

	right: 0;
	top: 100px;
}
table {
	width: 100%;
}

#mainNav .horizontalButton a {
	text-decoration:none;
	color: white;
}
a {
	text-decoration:none;
	color: black;
}
#hiddenOne {
	transition: .5s;
}
li {
	list-style: none;
}
.hidden {
	display: none;
 height: 0px;
}
.show {
display: block;
height: 50px;
}
#hiddenOne ul li {

	margin: 10px;
}
.input {
	height: 15px;
	width: 300px;
	padding:10px;
	margin: 10px;
	border-radius: 10px;
}
.button {
	width: 150px;
	height: 30px;
	border: 1px solid #666; 
	color:white;
	background-color: #b00000;
	border-radius: 5px; 
	padding: 4px; 
	font-size: 16px;
	box-shadow: 1px 10px 5px #888888;
}
.field {
	padding:30px;
	border-radius: 20px;
	box-shadow: 1px 10px 5px #888888;
}

</style>