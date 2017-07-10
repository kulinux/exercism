


class PhoneNumber( ph : String) {
	var number : Option[String] = None
	var areaCode : Option[String] = None
	var prettyPrint : Option[String] = None

	val sinPaja = ph.filter(x => x >= '0' && x <= '9')
	if(sinPaja.size == 10) {
		number = Some(sinPaja)
	} else if(sinPaja.size == 11 && sinPaja.head == '1') {
		number = Some(sinPaja.takeRight(10))
	} 


}
