document.addEventListener('DOMContentLoaded', function () {
  const container = document.getElementById('container');
  const target = document.getElementById('target');
  const follower = document.getElementById('follower');
  const coordinates = document.getElementById('coordinates');
  // 마우스 이동 추적
  document.addEventListener('mousemove', function (e) {
    const x = e.clientX;
    const y = e.clientY;

    // 좌표 표시
    coordinates.textContent = `X: ${x}, Y: ${y}`;

    // 부드러운 팔로워 이동
    follower.style.transform = `translate(${x - 10}px, ${y - 10}px)`;

    console.log('Mouse Move:', {
      type: e.type,
      x: x,
      y: y,
      target: e.target.tagName,
    });
  });
  // 클릭 이벤트
  document.addEventListener('click', function (e) {
    // 클릭 애니메이션 생성
    const circle = document.createElement('div');
    circle.className = 'click-animation';
    circle.style.left = e.clientX - 10 + 'px';
    circle.style.top = e.clientY - 10 + 'px';
    document.body.appendChild(circle);

    // 애니메이션 종료 후 제거
    setTimeout(() => circle.remove(), 600);

    console.log('Click:', {
      type: e.type,
      x: e.clientX,
      y: e.clientY,
      target: e.target.tagName,
    });
  });
  // 대상 요소 이벤트
  target.addEventListener('mouseenter', function (e) {
    this.style.backgroundColor = '#e0e0e0';
    console.log('Mouse Enter:', {
      type: e.type,
      target: e.target.tagName,
    });
  });
  target.addEventListener('mouseleave', function (e) {
    this.style.backgroundColor = '#f0f0f0';
    console.log('Mouse Leave:', {
      type: e.type,
      target: e.target.tagName,
    });
  });
});
