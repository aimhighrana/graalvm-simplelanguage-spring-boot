function checkAmIString(value) {
    str = java("org.springframework.util.StringUtils");

    // sleep for 5 seconds
    java("java.lang.Thread").sleep(5000);

    return str.hasText(value);
}

function main() {
    println("Check my string 'String' is empty or not");
    val = checkAmIString("String");
    println("Result , Does 'String' has some text :");
    println(val);
}
