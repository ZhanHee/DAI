function updatePrice() {
    let totalPrice = 0;
    // 遍历所有商品并更新价格
    let items = document.querySelectorAll('.product-item');
    items.forEach(function(item) {
        let quantity = parseInt(item.querySelector('.product-quantity').value);
        let price = parseFloat(item.querySelector('.product-price').innerText);
        let total = quantity * price;
        item.querySelector('.product-total').innerText = '$' + total.toFixed(2);

        // 累加每个商品的总价到购物车总价
        totalPrice += total;
    });

    // 更新购物车总价
    document.getElementById('cart-total').innerText = '$' + totalPrice.toFixed(2);
}

function changeQuantity(item, delta) {
    let quantityElement = item.querySelector('.product-quantity');
    let currentQuantity = parseInt(quantityElement.value);
    let newQuantity = currentQuantity + delta;

    // 如果数量大于0则更新
    if (newQuantity > 0) {
        quantityElement.value = newQuantity;
        updatePrice();
    }
}
