document.addEventListener('DOMContentLoaded', (event) => {

    const conselhoSelect = document.getElementById('checked');
    const conselhoField = document.getElementById('conselhos');
    const matriculaField = document.getElementById('matriculaConselho');
    const expedicaoField = document.getElementById('dataExpedicao');
    const ufField = document.getElementById('UF');

    function toggleConselhoFields() {

        const hasConselho = conselhoSelect.value ===  'true';

        matriculaField.disabled = !hasConselho;
        conselhoField.disabled = !hasConselho;
        expedicaoField.disabled = !hasConselho;
        ufField.disabled = !hasConselho;

        if (!hasConselho) {
            matriculaField.value = '';
            expedicaoField.value = '';
            ufField.value = '';

            conselhoField.selectedIndex = 0;

        }



    }

    conselhoSelect.addEventListener('change', toggleConselhoFields);
    toggleConselhoFields();
});