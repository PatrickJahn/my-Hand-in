import { render, screen } from '@testing-library/react';
import App from './App';


const app = {App};
test('renders learn react link', () => {
  render(<app />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});
