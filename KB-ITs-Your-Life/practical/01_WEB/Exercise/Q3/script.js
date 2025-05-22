document.addEventListener('DOMContentLoaded', function () {
  const form = document.getElementById('validationForm');
  const email = document.getElementById('email');
  const password = document.getElementById('password');
  const phone = document.getElementById('phone');

  // 이메일 검증
  email.addEventListener('keyup', function () {
    const isValid = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(this.value);
    updateValidation(this, isValid, '유효한 이메일 주소를 입력하세요');
  });

  // 비밀번호 검증
  password.addEventListener('keyup', function () {
    const isValid = /^(?=.*[!@#$%^&*])(?=.*[a-zA-Z0-9]).{8,}$/.test(this.value);
    updateValidation(this, isValid, '8자 이상, 특수문자를 포함해야 합니다');
  });

  // 전화번호 검증
  phone.addEventListener('keyup', function () {
    const isValid = /^\d+$/.test(this.value);
    updateValidation(this, isValid, '숫자만 입력하세요');
  });

  // 폼 제출
  form.addEventListener('submit', function (e) {
    e.preventDefault();

    const isEmailValid = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email.value);
    const isPasswordValid = /^(?=.*[!@#$%^&*])(?=.*[a-zA-Z0-9]).{8,}$/.test(
      password.value
    );
    const isPhoneValid = /^\d+$/.test(phone.value);

    if (isEmailValid && isPasswordValid && isPhoneValid) {
      console.log('폼 검증 완료!', {
        email: email.value,
        password: '********',
        phone: phone.value,
      });
    } else {
      alert('모든 필드를 올바르게 입력해주세요.');
    }
  });

  function updateValidation(element, isValid, errorMessage) {
    const errorElement = document.getElementById(element.id + 'Error');

    if (isValid) {
      element.classList.remove('invalid');
      element.classList.add('valid');
      errorElement.textContent = '';
    } else {
      element.classList.remove('valid');
      element.classList.add('invalid');
      errorElement.textContent = errorMessage;
    }
  }
});
