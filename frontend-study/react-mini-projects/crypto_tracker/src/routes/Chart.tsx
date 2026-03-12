import { useQuery } from '@tanstack/react-query';
import React from 'react';
import { fetchCoinHistory } from '../api';
import ApexCharts from 'react-apexcharts';

interface IHistorical {
  time_open: string;
  time_close: number;
  open: number;
  high: number;
  low: number;
  close: number;
  volume: number;
  market_cap: number;
}

interface ChartProps {
  coinId: string;
}
const Chart = ({ coinId }: ChartProps) => {
  const { isLoading, data } = useQuery<IHistorical[]>({
    queryKey: ['ohlcv', coinId],
    queryFn: () => fetchCoinHistory(coinId),
    refetchInterval:10000,
  });
  return (
    <div>
      {isLoading ? (
        'Loading chart...'
      ) : (
        <ApexCharts
          type="line"
          series={[
            {
              name: 'Price',
              data: data?.map((price) => Number(price.close)) ?? [],
            },
          ]}
          options={{
            theme: { mode: 'dark' },
            chart: {
              height: 300,
              width: 500,
              toolbar: {
                show: false,
              },
              background: 'transparent',
            },
            grid: { show: false },
            stroke: {
              curve: 'smooth',
              width: 7,
            },
            yaxis: { show: false },
            xaxis: {
              categories: data?.map((price) => price.time_close),
              type: 'datetime',
              axisBorder: { show: false },
              axisTicks: { show: false },
              labels: { show: false },
            },
            fill: {
              type: 'gradient',
              gradient: { gradientToColors: ['#0be881'], stops: [0, 100] },
            },
            colors: ['#0fbcf9'],
            tooltip: { y: { formatter: (value) => `$ ${value.toFixed(2)}` } },
          }}
        />
      )}
    </div>
  );
};

export default Chart;
