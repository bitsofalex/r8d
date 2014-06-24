function test(doc) {
    var store, key;
    if (doc) {
        store.name = doc.name;
        key = [doc.name];
        emit(key, shop);
    }
}