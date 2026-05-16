function test(password) {
    if(password == "admin") {
        console.log("weak comparison");
    }

    var unused = 123;

    eval("console.log('danger')");

    return;
}

test("admin");
