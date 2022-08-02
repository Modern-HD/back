document.getElementById('product_del_btn').addEventListener('click', () => {
    const del_form = document.getElementById('del_form');
    const pno_val = document.getElementById('pno').innerText;
    document.getElementById('input_pno').value = pno_val;
    del_form.setAttribute("action", "/product/delete");
    del_form.submit();
});