import { Link } from "react-router-dom"; // nếu dùng React Router

const NotFound = () => {
  return (
    <div className="flex flex-col items-center justify-center w-screen h-screen text-center bg-white p-6 gap-4">
      <img
        src="404_NotFound.png"
        alt="Page Not Found"
        className="max-w-md w-auto mb-6 animate-fade-in"
      />
      <h1 className="text-3xl font-bold mb-2">404 - Page Not Found</h1>
      <p className="text-lg text-gray-600 mb-6">
        Oops! Trang bạn đang tìm kiếm không tồn tại.
      </p>
      <Link
        to="/"
        className="px-6 py-3 font-medium text-white bg-blue-500 rounded-2xl shadow-md hover:bg-blue-600 transition transform hover:scale-105"
      >
        Quay về trang chủ
      </Link>
    </div>
  );
};

export default NotFound;
