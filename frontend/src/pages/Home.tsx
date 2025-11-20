const Home = () => {
  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100">
      <h1 className="text-4xl font-bold mb-4 text-blue-600">
        Welcome to Home Page
      </h1>

      <p className="text-gray-700 text-lg">
        Đây là trang Home của ứng dụng React + TypeScript + Tailwind.
      </p>

      <div className="mt-6">
        <a
          href="/about"
          className="px-4 py-2 bg-blue-500 text-white rounded-lg hover:bg-blue-600 transition"
        >
          Go to About
        </a>
      </div>
    </div>
  );
};
export default Home;
